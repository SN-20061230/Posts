package uz.sardor.myapplication.navigation

sealed class Screens (val route: String) {
    object HomeView: Screens("home_screen")
    object DetailsView: Screens("details_screen/{id}")
}