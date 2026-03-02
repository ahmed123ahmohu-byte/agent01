cmake_minimum_required(VERSION 3.22.1)
project("devsplit_ai")

# إضافة ملفات الـ C++ الخاصة بالـ Agent
add_library(devsplit_ai SHARED native-lib.cpp)

find_library(log-lib log)

target_link_libraries(devsplit_ai ${log-lib})
