package com.example.mapproy.presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.api.GoogleApiClient

interface ILoginPresenter {
    fun createGoogleAPiClient(context: Context, activity: AppCompatActivity)
    fun createGoogleSignInOptions():GoogleSignInOptions
    fun getGoogleAPiClient():GoogleApiClient
    fun getMapIntent():Intent
    fun getLoginResult(data: Intent?):GoogleSignInResult
    fun handleLoginResult(googleSignInResult: GoogleSignInResult)
}