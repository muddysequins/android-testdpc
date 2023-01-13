/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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