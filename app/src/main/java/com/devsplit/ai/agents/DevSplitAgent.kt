package com.devsplit.ai.agents

import androidx.compose.runtime.*
import com.devsplit.ai.core.LlamaEngine

enum class AgentState { IDLE, ANALYZING, GENERATING, DEBUGGING }

class DevSplitAgent(private val engine: LlamaEngine) {
    var status by mutableStateOf(AgentState.IDLE)
    var generatedCode by mutableStateOf("")

    suspend fun startAutonomousTask(userGoal: String) {
        status = AgentState.ANALYZING
        // الخطوة 1: تحليل الهدف (Brain Module)
        val plan = engine.infer("Plan for: $userGoal")
        
        status = AgentState.GENERATING
        // الخطوة 2: توليد الكود (Code Gen Module)
        generatedCode = engine.infer("Write HTML/CSS for $plan")
        
        status = AgentState.DEBUGGING
        // الخطوة 3: تصحيح ذاتي (Debug Module)
        val check = engine.infer("Check this code for errors: $generatedCode")
        if (check.contains("ERROR")) {
             generatedCode = engine.infer("Fix this: $generatedCode")
        }
        
        status = AgentState.IDLE
    }
}
