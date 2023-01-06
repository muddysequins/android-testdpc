package com.google.android.apps.work.dpcsupport;

import android.content.ComponentName;
import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public final class EnterpriseAccountSetup implements DefaultLifecycleObserver {

  public static EnterpriseAccountSetup fromComponentActivityOnCreate(
      ComponentActivity activity,
      ComponentName adminReceiver,
      EnterpriseAccountSetupCallback callback) {
    throw new RuntimeException("EnterpriseAccountSetup not implemented - requires DPC support library");
  }
  
  public EnterpriseAccountSetup(
      @NonNull ActivityResultRegistry registry,
      Context context,
      ComponentName admin,
      EnterpriseAccountSetupCallback callback) {
    throw new RuntimeException("EnterpriseAccountSetup not implemented - requires DPC support library");
  }
  
  public void addEnterpriseAccount(final String enrollmentToken) {
    throw new RuntimeException("EnterpriseAccountSetup not implemented - requires DPC support library");
  }

  @Override
  public void onCreate(@NonNull LifecycleOwner owner) {
    throw new RuntimeException("EnterpriseAccountSetup not implemented - requires DPC support library");
  }
  
  public final class ActivityLauncher {
    public void launch() {
      throw new RuntimeException("EnterpriseAccountSetup.ActivityLauncher not implemented - requires DPC support library");
    }
  }
  
}