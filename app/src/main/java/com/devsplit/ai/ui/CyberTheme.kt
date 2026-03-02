package com.devsplit.ai.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import android.webkit.WebView
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MainAgentScreen(agent: DevSplitAgent) {
    Row(modifier = Modifier.fillMaxSize().background(Color(0xFF010101))) {
        // يسار: Terminal Chat
        Column(modifier = Modifier.weight(0.4f).padding(16.dp)) {
            Text("DEV-SPLIT OS v1.0", color = Color.Green)
            Spacer(modifier = Modifier.height(20.dp))
            Text("Status: ${agent.status}", color = Color.Cyan)
            // قائمة المحادثة هنا...
        }

        // يمين: Live Preview (Neon Border)
        Box(modifier = Modifier.weight(0.6f).padding(8.dp)
            .border(2.dp, Color(0xFF00FFFF))) {
            AndroidView(factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                }
            }, update = { webView ->
                webView.loadData(agent.generatedCode, "text/html", "UTF-8")
            })
        }
    }
}
