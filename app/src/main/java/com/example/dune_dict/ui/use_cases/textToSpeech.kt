package com.example.dune_dict.ui.use_cases

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import java.util.*

fun textToSpeech(
    definition: String,
    onClickVolume: () -> Unit,
    context: Context
) {
    var textToSpeech: TextToSpeech? = null
    textToSpeech = TextToSpeech(context) {
        if (it == TextToSpeech.SUCCESS) {
            textToSpeech?.let { textToSpeech ->
                textToSpeech.language = Locale.US
                textToSpeech.setSpeechRate(0.9f)
                textToSpeech.speak(
                    definition,
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    "textToSpeech"
                )
                textToSpeech.setOnUtteranceProgressListener(object :
                    UtteranceProgressListener() {
                    override fun onDone(utteranceId: String?) {
                        onClickVolume()
                        Log.d("DetailWordScreen", "onDone")
                        textToSpeech.shutdown()
                    }

                    override fun onError(utteranceId: String?) {
                        textToSpeech.shutdown()
                    }

                    override fun onStart(utteranceId: String?) {
                    }
                })
            }
        }
    }
}


