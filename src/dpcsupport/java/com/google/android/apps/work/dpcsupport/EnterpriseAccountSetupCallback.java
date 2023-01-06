package com.google.android.apps.work.dpcsupport;

public interface EnterpriseAccountSetupCallback {


  enum ErrorStatus {
    /** An error occurred while updating the environment. */
    ENSURING_WORKING_ENVIRONMENT_FAILED,
    /** The user could not authenticate and could not skip (disabled by admin), they are blocked. */
    ENTERPRISE_AUTH_FAILED,
    /** Indicates that the user cancelled or skipped the authentication. */
    ENTERPRISE_AUTH_CANCELED,
    /** The enrollment token is not valid. */
    INVALID_TOKEN,
  }
  
  void onFailure(ErrorStatus error, Throwable throwable);
  
  void onAccountReady(EnterpriseAccount newAccount);

  default void onActivityStartRequired(EnterpriseAccountSetup.ActivityLauncher launcher) {
    throw new RuntimeException("EnterpriseAccountSetupCallback not implemented - requires DPC support library");
  }
}