package com.example.littlelemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.littlelemonapp.model.DatabaseHelper
import com.example.littlelemonapp.model.MenuItemEntity
import com.example.littlelemonapp.model.MenuItemNetwork
import com.example.littlelemonapp.model.MenuNetwork
import com.example.littlelemonapp.model.NetworkUtils
import com.example.littlelemonapp.model.transformFromResponseToDB
import com.example.littlelemonapp.navigation.Navigation
import com.example.littlelemonapp.ui.theme.LittleLemonAppTheme
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private var menuLiveData = MutableLiveData<List<MenuItemEntity>>()

    private val sharedPreferences by lazy {getSharedPreferences("LittleLemon", MODE_PRIVATE)}

    @Inject lateinit var databaseHelper: DatabaseHelper
    @Inject lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).appComponent.injectMainActivity(this)

        lifecycleScope.launch{
            val response = getMenu()

            val responseToDb = transformFromResponseToDB(response)

            withContext(IO) {
                databaseHelper.database.menuDao().saveMenuItem(responseToDb)
            }

            runOnUiThread {
                menuLiveData.value = responseToDb
            }
        }

        setContent {
            LittleLemonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    Navigation(
                        navController = navController, sharedPreferences = sharedPreferences,
                        menuItems = menuLiveData, onClick = ::onClick)

                }
            }
        }
    }

    private suspend fun getMenu(): List<MenuItemNetwork> {

        return networkUtils.client.get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
            .body<MenuNetwork>().menu

    }
    fun onClick(category: String) {
        lifecycleScope.launch(IO) {
            val result = databaseHelper.database.menuDao().getMenuItemsByCategory(category)
            println(result)
            runOnUiThread{
                menuLiveData.value = result
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LittleLemonAppTheme {
        Greeting("Android")
    }
}