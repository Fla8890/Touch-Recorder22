package com.touchrecorder.feature.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.touchrecorder.feature.editor.EditorScreen
import com.touchrecorder.feature.home.HomeScreen
import com.touchrecorder.feature.library.LibraryScreen
import com.touchrecorder.feature.macros.MacrosScreen
import com.touchrecorder.feature.settings.SettingsScreen

private data class AppTab(
    val route: String,
    val label: String,
    val symbol: String,
)

private val appTabs = listOf(
    AppTab("home", "Início", "⌂"),
    AppTab("macros", "Macros", "≡"),
    AppTab("editor", "Editor", "✎"),
    AppTab("library", "Biblioteca", "▤"),
    AppTab("settings", "Configurações", "⚙"),
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    Scaffold(
        bottomBar = {
            NavigationBar {
                appTabs.forEach { tab ->
                    val selected = currentDestination?.hierarchy?.any { it.route == tab.route } == true
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Text(text = tab.symbol) },
                        label = { Text(text = tab.label) },
                    )
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding),
        ) {
            composable("home") { HomeScreen() }
            composable("macros") { MacrosScreen() }
            composable("editor") { EditorScreen() }
            composable("library") { LibraryScreen() }
            composable("settings") { SettingsScreen() }
        }
    }
}
