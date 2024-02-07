## Fitness Application(разработка функционала, пока без дизайна)

Приложение для отслеживания потребляемых за день калорий.
В коде представлен только один фрагмент приложения - экран поиска

## Задачи

* Создать интуитивно понятный интерфейс
* Дать пользователю максимальный простор для действий
* Создать анимации, улучшающие пользовательский опыт
* Дать возможность управления созданными рецептами, блюдами и приемами пищи из страницы поиска
* Освоение нового фрэймворка для написания пользовательского интерфейса
* Реализовать навигацию без фрагментов, только на Composable функциях
* Оптимизация кода на Compose

## Краткое описание интерфейса
При попадании на экран поиска отображается панель поиска и история посиковых запросов. При нажатии на элемент из
истории происходит поиск продуктов по этому названию. При завершении поиска пользователю отображается список найденных подуктов.
Список найденных продуктов получается частями с помощью пагинации, а не грузится весь сразу, так как может быть очень большим.

При клике на продукт из списка отображаеться окно с подбробной информацией о нем, на котором отображается
информация по калорийности и БЖУ продукта, есть возможность измения количества грамм(мл, lbs) и прием
пищи, в который этот продукт должен быть добавлен.

При выборе продукта из списка происходит анимация верхней панели экрана. На новой панели отображается количество выбранных продуктов,
стрелка для выхода из режима выбора и кнопка для добавления всех выбранных продуктов в дневник питания.

Также для удобства пользователя отображается панель с перечислением всех названий продуктов, которые выбрал пользователей. По клику на
название можно быстро удалить продукт из выбранных. У каждого выбранного продукта отображается прием пищи, для которого этот
подукт был выбран.

При переходе на другие вкладки(мои рецепты, приемы пищи и мои блюда) отображается список всех блюд, рецептов и приемов пищи, которые
пользователь создал вручную. В этих вкладках так же присутствует функция выбора элемента.  

Возможно удаление созданных пользователем элементов из базы данных путем смахивания влево или вправо. При этом показывается белая
иконка корзины на красном заднем фоне, что говорит о возможном удалении при смахивании объекта в данном направлении

## Архитектура

* [MVVM](https://developer.android.com/jetpack/guide)
* Clean Architecture

## IDE

* [Android Studio](https://developer.android.com/studio)
* [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/)

## Стек технологий

* [Kotlin](https://kotlinlang.org/)
* [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
* [Flow](https://kotlinlang.org/docs/flow.html)
* [Compose](https://developer.android.com/jetpack/compose)
* [Dagger 2](https://dagger.dev/)
* [Retrofit](https://square.github.io/retrofit/)
* [Room](https://developer.android.com/jetpack/androidx/releases/room)

## Libraries

* Jetpack Compose
    * [Compose Material Components](https://developer.android.com/jetpack/androidx/releases/compose-material3)
    * [Material Icons Extended](https://mvnrepository.com/artifact/androidx.compose.material/material-icons-extended)
    * [Compose UI Primitives](https://developer.android.com/jetpack/androidx/releases/compose-ui)
    * [Paging Compose](https://developer.android.com/jetpack/androidx/releases/paging)
    * [Compose tooling](https://mvnrepository.com/artifact/androidx.compose.ui/ui-tooling)
    * [Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
* Di
    * [Dagger2](https://dagger.dev/)
    * [Dagger Compiler](https://mvnrepository.com/artifact/com.google.dagger/dagger-compiler)
* Retrofit2 & OkHttp3
    * [Converter: Gson](https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson)
    * [Retrofit](https://square.github.io/retrofit/)
    * [OkHttp Logging Interceptor](https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor)
* Room
    * [Android Room Runtime](https://mvnrepository.com/artifact/androidx.room/room-runtime)
    * [Android Room Kotlin Extensions](https://mvnrepository.com/artifact/androidx.room/room-ktx)
    * [Android Room Compiler](https://mvnrepository.com/artifact/androidx.room/room-compiler)
* Test
    * [JUnit](https://mvnrepository.com/artifact/junit/junit)
    * [Mockito](https://github.com/mockito/mockito)
    * [UI Test Junit4](https://developer.android.com/jetpack/compose/testing#setup)
    * [UI Test Manifest](https://developer.android.com/jetpack/compose/testing#setup)
* Other
    * [Compose Activity](https://developer.android.com/jetpack/androidx/releases/activity)
    * [Android ViewModel](https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-viewmodel-ktx)
    * [Kotlin multiplatform serialization](https://github.com/Kotlin/kotlinx.serialization)
    * [Kotlinx DateTime](https://github.com/Kotlin/kotlinx-datetime)
    * [Core Kotlin Extensions](https://developer.android.com/kotlin/ktx#core)


