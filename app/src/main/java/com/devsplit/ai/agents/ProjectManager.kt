package com.devsplit.ai.agents

class ProjectManager(private val brain: LlamaEngine) {
    
    // وظيفة الـ Agent لإنشاء مشروع متكامل تلقائياً
    suspend fun buildProject(instruction: String): Map<String, String> {
        val projectFiles = mutableMapOf<String, String>()
        
        // 1. التفكير في الهيكل
        val structure = brain.infer("Create file structure for: $instruction. Output: filename:description")
        
        // 2. التوليد المتسلسل
        structure.split("\n").forEach { line ->
            val fileName = line.split(":")[0]
            val code = brain.infer("Write full code for $fileName based on $instruction")
            
            // 3. المراجعة الذاتية (Reviewer Agent)
            val validatedCode = reviewAndFix(code)
            projectFiles[fileName] = validatedCode
        }
        
        return projectFiles
    }

    private suspend fun reviewAndFix(code: String): String {
        val feedback = brain.infer("Check this code for syntax errors. If fine, say 'PASS', else give fix: $code")
        return if (feedback.contains("PASS")) code else feedback
    }
}
