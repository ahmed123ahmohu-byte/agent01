package com.devsplit.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.devsplit.ai.core.LlamaEngine
import com.devsplit.ai.agents.EvolutionEngine
import com.devsplit.ai.ui.MainAgentScreen
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val llama = LlamaEngine()
    private val agent = EvolutionEngine(llama)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // تحميل الموديل عند التشغيل (يجب أن يكون في assets)
        llama.initModel("/data/user/0/com.devsplit.ai/files/model.gguf")

        setContent {
            // هنا تظهر شاشة الـ Cyber UI المقسمة نصفين
            MainAgentScreen(agent = agent)
        }
    }
}
