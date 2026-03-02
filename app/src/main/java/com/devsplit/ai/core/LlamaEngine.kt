package com.devsplit.ai.core

import android.util.Log

/**
 * LlamaEngine: المحرك المسؤول عن تشغيل الموديل محلياً (On-Device).
 */
class LlamaEngine {

    init {
        // تحميل المكتبة التي بنيناها في الـ CPP (native-lib.cpp)
        try {
            System.loadLibrary("devsplit_ai")
        } catch (e: Exception) {
            Log.e("LlamaEngine", "Native library failed to load: ${e.message}")
        }
    }

    /**
     * وظيفة الربط مع كود C++ (JNI)
     * تقوم بإرسال الـ Prompt واستقبال الكود المولد
     */
    external fun infer(prompt: String): String

    /**
     * تهيئة الموديل من ملف الـ assets
     */
    external fun initModel(modelPath: String): Int

    // ملاحظة: الـ Agent (EvolutionEngine) ينادي دالة infer() ليقوم بالتفكير
}
