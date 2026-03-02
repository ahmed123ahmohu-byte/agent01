#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_devsplit_ai_core_LlamaEngine_infer(JNIEnv* env, jobject thiz, jstring prompt) {
    return env->NewStringUTF("Agent Response: Code Generated Successfully");
}

extern "C" JNIEXPORT jint JNICALL
Java_com_devsplit_ai_core_LlamaEngine_initModel(JNIEnv* env, jobject thiz, jstring path) {
    return 0; // Success
}
