/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package be.pieterpletinckx.supplystorage.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import be.pieterpletinckx.supplystorage.ui.home.HomeDestination
import be.pieterpletinckx.supplystorage.ui.home.HomeScreen
import be.pieterpletinckx.supplystorage.ui.item.ItemDetailsDestination
import be.pieterpletinckx.supplystorage.ui.item.ItemDetailsScreen
import be.pieterpletinckx.supplystorage.ui.item.ItemEditDestination
import be.pieterpletinckx.supplystorage.ui.item.ItemEditScreen
import be.pieterpletinckx.supplystorage.ui.item.ItemEntryDestination
import be.pieterpletinckx.supplystorage.ui.item.ItemEntryScreen
import be.pieterpletinckx.supplystorage.ui.location.LocationEntryDestination
import be.pieterpletinckx.supplystorage.ui.location.LocationEntryScreen
import be.pieterpletinckx.supplystorage.ui.search.SearchByName
import be.pieterpletinckx.supplystorage.ui.search.SearchByNameScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = SearchByName.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                navigateToItemUpdate = { navController.navigate("${ItemDetailsDestination.route}/${it}") }
            )
        }
        composable(route = SearchByName.route) {
            SearchByNameScreen(
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                navigateToItemUpdate = { navController.navigate("${ItemDetailsDestination.route}/${it}") }
            )
        }
        composable(route = ItemEntryDestination.route) {
            ItemEntryScreen(
                navigateToLocationEntry = {},
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemDetailsScreen(
                navigateToEditItem = { navController.navigate("${ItemEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(route = LocationEntryDestination.route) {
            LocationEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}
