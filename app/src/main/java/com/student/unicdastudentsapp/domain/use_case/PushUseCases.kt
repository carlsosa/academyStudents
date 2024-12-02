package com.student.unicdastudentsapp.domain.use_case

class  PushUseCases  private constructor() {
        companion object {

            @Volatile
            private var instance: PushUseCases? = null
            private var token: String = "N/A"
            fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: PushUseCases().also { instance = it }
                }
        }

        fun setToken(str: String){
           token = str
        }
        fun getToken(): String = token

}