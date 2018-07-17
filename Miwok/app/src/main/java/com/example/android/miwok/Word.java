package com.example.android.miwok;

public class Word {

/** Default translation for the Word */
    private String mDefaultTranslation;

            /** Miwok translation for the Word */
            private String mMiwokTranslation;

            /**
      * Create a new Word object.
      *
      * @param defaultTranslation is the Word in a language that the user is already familiar with
      *                           (such as English)
      * @param miwokTranslation is the Word in the Miwok language
      */
            public Word(String defaultTranslation, String miwokTranslation) {
                mDefaultTranslation = defaultTranslation;
                mMiwokTranslation = miwokTranslation;
            }

            /**
      * Get the default translation of the Word.
      */
            public String getDefaultTranslation() {
                return mDefaultTranslation;
            }

           /**
      * Get the Miwok translation of the Word.
      */
            public String getMiwokTranslation() {
                return mMiwokTranslation;
           }

        }
