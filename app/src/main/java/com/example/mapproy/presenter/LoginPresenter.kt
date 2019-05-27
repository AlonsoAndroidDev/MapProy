package com.example.mapproy.presenter

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.example.mapproy.model.UserModel
import com.example.mapproy.view.ILoginView
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient

class LoginPresenter(private var iLoginView: ILoginView) : ILoginPresenter, GoogleApiClient.OnConnectionFailedListener {

    private lateinit var userModel: UserModel
    private lateinit var googleApiClient: GoogleApiClient
    private lateinit var googleSignInOptions : GoogleSignInOptions

    override fun createGoogleAPiClient(context: Context,activity: AppCompatActivity) {
        googleApiClient = GoogleApiClient.Builder(context)
            .enableAutoManage(activity, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, createGoogleSignInOptions())
            .build()
    }

    override fun createGoogleSignInOptions():GoogleSignInOptions{
        googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        return googleSignInOptions
    }

    override fun getGoogleAPiClient():GoogleApiClient {
        return googleApiClient
    }

    override fun getMapIntent():Intent{
        return Auth.GoogleSignInApi.getSignInIntent(getGoogleAPiClient())
    }

    override fun getLoginResult(data: Intent?): GoogleSignInResult {
        return Auth.GoogleSignInApi.getSignInResultFromIntent(data)
    }

    override fun handleLoginResult(googleSignInResult: GoogleSignInResult){

    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}