Please navigate to Releases Tab for the PPT of the approach .

# LoginRevised - Approach 2 (Newer Approach)

Flexible , Configurable , Easy to plug Login Kit Library Version 1.1

Min SDK API Version  :24

Integration Steps 

1.  Add in your root build.gradle file 

        allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

2.    Add the dependency 
         dependencies {
	        implementation 'com.github.shaillypanchal1991:CustomizableLogin:1.1'
	}

Steps to integrate 

1.  Initialize the Library  (Preferable in Splash Activity or Application class)

        private void initializeLoginKit() {

        RootLoginController rootLoginController = RootLoginController.init();

Add your own custom configuration the following way 👍

        rootLoginController.customConfiguration.isLoggingEnable = true;
        rootLoginController.customConfiguration.retryCount = 2;
        rootLoginController.customConfiguration.uiComponents.backgroundColor = "#ffffff";
        rootLoginController.customConfiguration.domainURL = "https://usermgt-staging.shared-  svc.bellmedia.ca";

After initializing the RootController object call loadLoginKit() function 👍 

        rootLoginController.loadLoginKit(this, rootLoginController);

Now the login kit library is initialized.


Functionalities Provided

1.  Login with Credentials
2. Load User Profiles
3. Login with Profile ID
4. Refresh Token when expired

Steps to build a shell app for the library 

1.  Initialize Login kit library as mentioned above.
2. Make a common instance of CallbackManager preferably in the Application class 
      CallbackManager callbackManager = new CallbackManager()
3.  To perform login on your Login Activity 
     
 callbackManager.loginwithCredentials(this, 
RequestType.LOGIN_WITH_CREDENTIALS,
 "protiksengupta@yahoo.com", "PoC@2019");

Implement interface CallbackHelper.GenericCallbacks 


Receive following callbacks 



 
    @Override
    public void onLoginSuccess(Login liveData) {
        
        accesstoken=liveData.getAccessToken();
        refreshtoken=liveData.getRefreshToken();

        callbackManager.loadProfiles(this,"Profiles",accesstoken);

    }

    @Override
    public void onLoginFailure(CustomException apiException) {
        
    }
    

When user has successfully logged in, you can all the load profiles funtion and receive the profile success/failure callbacks


     @Override
    public void onProfileSuccess(List<Profile> lstProfiles) {

        populateData(lstProfiles);
    }

    @Override
    public void onProfileFailure(CustomException apiException) {

        if (NetworkUtils.isNetworkConnected(this)) {
            ShellApplication.getCommonListener().refreshToken(this, RequestType.REFRESH_TOKEN, DataStore.getInstance().fetchUserSessionDetails().getRefreshToken());
        } else {
            Toast.makeText(this, "You are not connected to internet ", Toast.LENGTH_SHORT).show();
        }
    }
    

In case of profile Fetch Failure, user can call refreshToken to renew the expired token .Following is the callback received .

	 @Override
    public void onRefreshTokenFailure(CustomException apiException) {

        Toast.makeText(this,"There seems to be some error",Toast.LENGTH_SHORT).show();
        HashMap<String,String> eventParams = new HashMap<String,String>();
        eventParams.put("username", DataStore.getInstance().fetchUserName());
        eventParams.put("error", apiException.getErrorMessage(apiException.getErrorCode()));

        AnalyticsServiceManager.getInstance().pushAnalyticsEvent("refresh_session_failure",eventParams);

    }

    @Override
    public void onRefreshTokenSucess(Login data) {

        DataStore.getInstance().storeUserSessionDetails(data);
        makeProfilesRequest();


        HashMap<String,String> eventParams = new HashMap<String,String>();
        eventParams.put("username", DataStore.getInstance().fetchUserName());
        AnalyticsServiceManager.getInstance().pushAnalyticsEvent("refresh_session_success",eventParams);


    }
    
    
    
    
Now when the profiles are populated , user can call loginWithProfile function on profile click and get following callbacks

	@Override
    public void onProfileLoginSuccess(Login data) {

        Intent in = new Intent(ProfilesActivity.this, HomeActivity.class);
        startActivity(in);

        finish();
    }


    @Override
    public void onProfileLoginFailure(CustomException apiException) 
    {
     

        Toast.makeText(this,"Unable to fetch profiles",Toast.LENGTH_SHORT).show();
    }
    
    



Note : RequestType is an enum differentiating the request ;
It has following values and can be scaled in future.

    LOGIN_WITH_CREDENTIALS,
    LOAD_PROFILES,
    LOGIN_WTH_PROFILE_ID,
    REFRESH_TOKEN

Following are all the callbacks received from the Callback Manager class


        public void onLoginSuccess(Login liveData);


        public void onLoginFailure(CustomException apiException);


        public void onProfileSuccess(List<Profile> lstProfiles);


        public void onProfileFailure(CustomException apiException);

        public void onProfileLoginSuccess(Login data);

        public void onProfileLoginFailure(CustomException apiException);

        public void onRefreshTokenSucess(Login data);

        public void onRefreshTokenFailure(CustomException apiException);}
	
	
User can save the data on his end (the tokens,credentials) and encrypt them the way it needs to.






