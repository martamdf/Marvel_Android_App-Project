package com.example.practicasuperpoderes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicasuperpoderes.ui.superherolist.SuperHeroListScreen
import com.example.practicasuperpoderes.ui.superherolist.SuperHeroListViewModel

@Composable
fun NavigationGraph(superHeroListViewModel: SuperHeroListViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SuperheroScreen.route) {
//        composable(Screens.LoginScreen.route) {
//            LoginScreen(viewModel = loginViewModel) {
//                navController.navigate(Screens.SuperheroScreen.route)
//            }
//        }

        composable(Screens.SuperheroScreen.route) {
            SuperHeroListScreen(viewModel = superHeroListViewModel)
        }
    }
}