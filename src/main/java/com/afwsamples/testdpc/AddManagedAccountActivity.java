package com.afwsamples.testdpc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

import com.google.android.apps.work.dpcsupport.EnterpriseAccount;
import com.google.android.apps.work.dpcsupport.EnterpriseAccountSetup;
import com.google.android.apps.work.dpcsupport.EnterpriseAccountSetupCallback;
import com.google.android.setupcompat.template.FooterBarMixin;
import com.google.android.setupcompat.template.FooterButton;
import com.google.android.setupdesign.GlifLayout;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AddManagedAccountActivity extends ComponentActivity {

  private static final String TAG = "AddManagedAccountActivity";
  public static final String EXTRA_NEXT_ACTIVITY_INTENT = "nextActivityIntent";
  private EnterpriseAccountSetup enterpriseAccountSetup;
  private Intent mNextActivityIntent = null;

  public static boolean isDPCSupportLibraryPresent(Context context) {
    try {
      EnterpriseAccountSetup test = new EnterpriseAccountSetup(null, context, null, null);
      Log.d(TAG,
          "Successfully creates an instance of EnterpriseAccountSetup - DPC Support Library appears to be real");
      return true;
    } catch (RuntimeException e) {
      Log.d(TAG,
          "Create EnterpriseAccountSetup caused a runtime exception - DPC Support library is not real",
          e);
      return false;
    }
  }

  ;

  private final EnterpriseAccountSetupCallback enterpriseAccountSetupCallback =
      new EnterpriseAccountSetupCallback() {
        public void onFailure(ErrorStatus error, Throwable throwable) {
          Log.e(TAG, "EnterpriseAccountSetup - failed", throwable);
          Toast.makeText(AddManagedAccountActivity.this, R.string.fail_to_add_managed_account,
                  Toast.LENGTH_LONG)
              .show();
        }

        public void onAccountReady(EnterpriseAccount newAccount) {
          String userEmail = newAccount.getEmailAddress();
          String userId = newAccount.getUserId();
          boolean userAuthenticatedByGoogle = newAccount.isUserAuthenticatedByGoogle();
          Log.i(TAG, String.format(
              "EnterpriseAccountSetup - succeeded. id = %s, email = '%s', authenticated = %b",
              userId, userEmail, userAuthenticatedByGoogle));
          Toast.makeText(AddManagedAccountActivity.this, R.string.success_add_managed_account,
                  Toast.LENGTH_LONG)
              .show();
          if (mNextActivityIntent != null) {
            startActivity(mNextActivityIntent);
          }
          finish();
        }
      };

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // This is the DPC’s DeviceAdminReceiver (see https://developer.android.com/work/dpc/build-dpc#create_a_dpc)
    ComponentName adminReceiver = new ComponentName(this, DeviceAdminReceiver.class);
    enterpriseAccountSetup = EnterpriseAccountSetup.fromComponentActivityOnCreate(
        AddManagedAccountActivity.this, adminReceiver, enterpriseAccountSetupCallback);

    setContentView(R.layout.activity_add_managed_account);
    GlifLayout layout = findViewById(R.id.setup_wizard_layout);
    FooterBarMixin mixin = layout.getMixin(FooterBarMixin.class);
    mixin.setPrimaryButton(
        new FooterButton.Builder(this)
            .setText(R.string.sud_next_button_label)
            .setListener(this::onNavigateNext)
            .setButtonType(FooterButton.ButtonType.NEXT)
            .setTheme(R.style.SudGlifButton_Primary)
            .build());

    Bundle extras = getIntent().getExtras();
    if (extras != null) {
      mNextActivityIntent = (Intent) extras.get(EXTRA_NEXT_ACTIVITY_INTENT);
    }
  }

  String enrollmentToken = "";

  public void onNavigateNext(View nextButton) {
    EditText token = (EditText) findViewById(R.id.enrollment_token);
    Log.d(TAG, "Enrollment token: " + token.getText().toString());
    enterpriseAccountSetup.addEnterpriseAccount(token.getText().toString());
  }
}