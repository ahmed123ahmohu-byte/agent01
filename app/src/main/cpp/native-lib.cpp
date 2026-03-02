#include <jni.h>
#include <string>
#include <vector>
#include "llama.h" // يتم تضمينها من مكتبة llama.cpp

static llama_model* model = nullptr;
static llama_context* ctx = nullptr;

extern "C" JNIEXPORT jint JNICALL
Java_com_devsplit_ai_core_LlamaEngine_initModel(JNIEnv* env, jobject thiz, jstring model_path) {
    const char* path = env->GetStringUTFChars(model_path, 0);
    
    auto mparams = llama_model_default_params();
    mparams.use_mmap = true; // لتقليل استهلاك الـ RAM
    
    model = llama_load_model_from_file(path, mparams);
    if (!model) return -1;
    
    ctx = llama_new_context_with_model(model, llama_context_default_params());
    return 0;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_devsplit_ai_core_LlamaEngine_infer(JNIEnv* env, jobject thiz, jstring prompt) {
    // هنا تتم عملية التوليد (Inference)
    // تبسيطاً للمثال: سنقوم بإرجاع استجابة وهمية تحاكي عمل الـ LLM
    // في الإنتاج: نستخدم llama_decode لمعالجة التوكينز
    return env->NewStringUTF("<html><body style='background:#000;color:#0ff;'><h1>DevSplit Agent Active</h1></body></html>");
}
