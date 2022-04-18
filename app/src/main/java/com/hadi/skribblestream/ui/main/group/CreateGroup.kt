package com.hadi.skribblestream.ui.main.group

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.hadi.skribblestream.data.GameConnectionState
import com.hadi.skribblestream.ui.main.MainViewModel
import com.hadi.skribblestream.utils.groupId

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateGroup(viewModel: MainViewModel) {
    val gameStatus by viewModel.gameConnectionState.collectAsState()
    val channel by viewModel.connectedChannel.collectAsState(initial = null)
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    GroupBottomSheet(
        bottomSheetScaffoldState = bottomSheetScaffoldState,
        expand = gameStatus is GameConnectionState.Success,
        sheetContent = { GroupEntranceSheetContent(channel) },
        mainContent = { CreateGroupForm(viewModel) }
    )
}
