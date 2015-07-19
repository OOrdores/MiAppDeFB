package ordores.dev.miappdefb;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainFragment extends Fragment {

    private  String id, correo, nombre;

    private TextView mTextDetail;

    private CallbackManager mcallBackManager;
    private FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();
            displayWelcomeMessage(profile);
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };

    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mcallBackManager = CallbackManager.Factory.create();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private void redireccionarActivity(Profile profile){
        if(profile != null){

            mTextDetail.setText("Bienvenido a la App Mi Telecticket " + profile.getName());
        }

    }

    private void displayWelcomeMessage(Profile profile){
        if(profile != null){
            mTextDetail.setText("Bienvenido a la App Mi Telecticket " + profile.getName());
        }

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.setFragment(this);
        loginButton.registerCallback(mcallBackManager,mCallBack);

    }

    @Override
    public void onResume() {
        super.onResume();
        Profile  profile = Profile.getCurrentProfile();
        displayWelcomeMessage(profile);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mcallBackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void datosUsuario(Profile profile){
        id = profile.getId();
        nombre = profile.getFirstName();

    }

}
