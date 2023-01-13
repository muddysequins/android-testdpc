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