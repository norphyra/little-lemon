package com.example.littlelemonapp

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.rememberNavController
import com.example.littlelemonapp.model.DatabaseHelper
import com.example.littlelemonapp.model.MenuItemEntity
import com.example.littlelemonapp.model.MenuItemNetwork
import com.example.littlelemonapp.model.MenuNetwork
import com.example.littlelemonapp.model.MenuRepositoryImpl
import com.example.littlelemonapp.model.MenuViewModel
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

    @Inject lateinit var sharedPreferences: SharedPreferences

    @Inject lateinit var viewModelFactory: MenuViewModel.MenuViewModelFactory.Factory

    private val viewModel: MenuViewModel by viewModels { viewModelFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.appComponent.injectMainActivity(this)

        lifecycleScope.launch(context = IO){

            viewModel.menu.collect {
                runOnUiThread {
                    menuLiveData.value = it
                }
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

    fun onClick(category: String) {
        lifecycleScope.launch(IO) {
            val result = viewModel.getMenuItemsByCategory(category = category)
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