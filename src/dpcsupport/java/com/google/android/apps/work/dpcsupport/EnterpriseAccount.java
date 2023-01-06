package com.google.android.apps.work.dpcsupport;

public final class EnterpriseAccount {

  EnterpriseAccount(String emailAddress, String userId, boolean userAuthenticatedByGoogle) {
    throw new RuntimeException("EnterpriseAccount not implemented - requires DPC support library");
  }

  public String getEmailAddress() {
    throw new RuntimeException("EnterpriseAccount not implemented - requires DPC support library");
  }

  public String getUserId() {
    throw new RuntimeException("EnterpriseAccount not implemented - requires DPC support library");
  }

  public boolean isUserAuthenticatedByGoogle() {
    throw new RuntimeException("EnterpriseAccount not implemented - requires DPC support library");
  }
}