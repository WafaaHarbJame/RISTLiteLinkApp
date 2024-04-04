package com.ristlitelink.ristlitelink.apiHandler

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

//    //...............................POST..................................
//
//    @POST("back-end/admin/api/v1/auth/login")
//    fun loginUserHandle(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: LoginCall?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//    @POST("back-end/admin/api/v1/auth/login")
//    fun loginPoHandle(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: LoginCall?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//
//    @POST("back-end/common/api/v1/auth/login")
//    fun loginHrmHandle(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: LoginCall?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//
//    @POST("back-end/common/api/v1/auth/signup")
//    fun registerHrmHandle(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: RegisterCall?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//    @POST("back-end/admin/api/v1/createuser")
//    fun registerPoHandle(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: RegisterCall?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//    @POST("back-end/admin/api/v1/auth/refreshtoken")
//    fun refreshToken(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: RefreshTokenCallModel?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//
//    @POST("back-end/common/api/v1/auth/refreshtoken")
//    fun refreshHrmToken(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: RefreshTokenCallModel?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//
//    @POST("back-end/admin/api/v1/user/updateloggeduserprofile")
//    fun updateUserData(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: UpdateProfileCall?
//    ): Call<ResultAPIModel<ProfileModel?>?>?
//
//
//    @POST("back-end/common/api/v1/user/updateloggeduserprofile")
//    fun updateHrmUserData(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: UpdateProfileCall?
//    ): Call<Any?>?
//
//
//    @POST("back-end/admin/api/v1/user/updateloggeduserprofile")
//    fun updatePoUserData(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: UpdatePoProfileCall?
//    ): Call<Any?>?
//
//
//    @POST("back-end/admin/api/v1/user/updateloggeduserpassword")
//    fun updatePassword(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: UpdatePasswordCall?
//    ): Call<ResultAPIModel<String?>?>?
//
//    @POST("back-end/admin/api/v1/user/updateloggeduserpassword")
//    fun updatePoPassword(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: UpdatePoPasswordCall?
//    ): Call<ResultAPIModel<String?>?>?
//
//
//    @POST("back-end/common/api/v1/user/updateloggeduserpassword")
//    fun updateHrmPassword(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: UpdatePoPasswordCall?
//    ): Call<ResultAPIModel<String?>?>?
//
//
//    @Multipart
//    @POST("back-end/common/api/v1/user/updateloggeduserimage")
//    fun uploadProfileImage(
//        @HeaderMap headerParam: MutableMap<String, Any>,
////        @Part("imagefile") file: File,
//        @Part("imagefile") file: RequestBody
////        @Body requestBody: RequestBody?
//    ): Call<ResultAPIModel<String?>?>?
//
//
//    @POST("back-end/admin/api/v1/user/updateloggeduserimage")
//    fun updateUsersImage(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: UpdatePasswordCall?
//    ): Call<ResultAPIModel<String?>?>?
//
//
//    @POST("back-end/admin/api/v1/create-inandout-request")
//    fun createRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: CreateRequestCall?
//    ): Call<ResultAPIModel<RequestHrmModel?>?>?
//
//    @POST("back-end/admin/api/v1/create-porequest")
//    fun createPoRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: AddPoRequestCall?
//    ): Call<ResultAPIModel<RequestPoModel?>?>?
//
//    @POST("back-end/admin/api/v1/auth/registeruserdevice")
//    fun registerUserDevice(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: RegisterTokenCall?
//    ): Call<ResultAPIModel<RegisterTokenResponse?>?>?
//
//    @POST("back-end/common/api/v1/auth/registeruserdevice")
//    fun registerHrmDevice(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: RegisterHrmTokenCall?
//    ): Call<ResultAPIModel<RegisterTokenResponse?>?>?
//
//
//    @POST("back-end/admin/api/v1/auth/verifyotp")
//    fun otpVerifyUserHandle(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: OtpCall?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//    @POST("back-end/admin/api/v1/auth/resendloginotp")
//    fun resendloginotpHandler(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: OtpCall?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//    @POST("back-end/admin/api/v1/approverequest")
//    fun approveRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: ApproveCall?
//    ): Call<ResultAPIModel<LoginCallModel?>?>?
//
//
//    @POST("back-end/admin/api/v1/createsupplier")
//    fun createSupplier(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Body param: AddSupplierCall?
//    ): Call<ResultAPIModel<SupplierModel?>?>?
//
//
//    //...............................GET..................................
//
//    @GET("back-end/admin/api/v1/getallrequestscount")
//    fun getAllRequestsCount(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("type") type: String?
//    ): Call<ResultAPIModel<Int?>?>?
//
//
//    @GET("back-end/admin/api/v2/getallrequests")
//    fun getAllRequests(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<RequestModel>?>?>?
//
//    @GET("back-end/admin/api/v1/getcurrencydd")
//    fun getCurrencyDD(
//        @HeaderMap headerParams: MutableMap<String, Any>
//    ): Call<ResultAPIModel<MutableList<CurrencyModel>?>?>?
//
//
//    @GET("back-end/admin/api/v1/get-all-inandouts")
//    fun getHrmAllRequests(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<RequestHrmModel>?>?>?
//
//    @GET("back-end/admin/api/v1/get-all-porequests")
//    fun getPoRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<RequestPoModel>?>?>?
//
//    @GET("back-end/admin/api/v1/getallsuppliers")
//    fun getAllSuppliers(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<SupplierModel>?>?>?
//
//    @GET("back-end/admin/api/v1/getsupplierdd")
//    fun getSupplierById(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<SupplierModel>?>?>?
//
//
//    @GET("back-end/admin/api/v1/get-inout-count")
//    fun getHrmCountRequests(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//    ): Call<ResultAPIModel<MutableList<HomeModel>?>?>?
//
//
//    @GET("back-end/admin/api/v1/getorganizationdd")
//    fun getOrganizations(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//    ): Call<ResultAPIModel<MutableList<OrganizationModel>?>?>?
//
//    @GET("back-end/admin/api/v1/getleavetypedd")
//    fun getLeaveType(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//    ): Call<ResultAPIModel<MutableList<LevelTypeModel>?>?>?
//
//
//    @GET("back-end/admin/api/v1/get-essl-devielogs")
//    fun getOutTimesDropDown(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<EsslModel>?>?>?
//
//
//    @GET("back-end/admin/api/v1/getrequesttypedropdown")
//    fun getRequestTypes(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("orgId") orgId: String?
//    ): Call<ResultAPIModel<MutableList<RequestTypeModel>?>?>?
//
//
//    @GET("back-end/admin/api/v1/getrequest")
//    fun getRequestData(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?
//    ): Call<ResultAPIModel<RequestModel?>?>?
//
//    @GET("back-end/admin/api/v1/get-inandout-request")
//    fun getHrmRequestData(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?
//    ): Call<ResultAPIModel<RequestHrmModel?>?>?
//
//    @GET("back-end/admin/api/v1/get-porequest")
//    fun getPoRequestData(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?
//    ): Call<ResultAPIModel<RequestPoModel?>?>?
//
//    @GET("back-end/admin/api/v1/get-porequest-items")
//    fun getPoRequestItems(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("poId") id: String?
//    ): Call<ResultAPIModel<MutableList<TblPurchaseRequestItem>?>?>?
//
//
////    @GET("back-end/admin/api/v1/get-porequest")
////    fun getPoRequestData(
////        @HeaderMap headerParams: MutableMap<String, Any>,
////        @Query("poId") id: String?
////    ): Call<ResultAPIModel<RequestPoModel?>?>?
//
//    @GET("back-end/common/api/v1/getdepartmentdd")
//    fun getDepartments(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<DepartmentModel>?>?>?
//
//    @GET("back-end/admin/api/v1/getfacilitydd")
//    fun getfacilitydd(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<FaclityModel>?>?>?
//
//
//    @GET("back-end/admin/api/v1/getallcurrencies")
//    fun getCurrencyDD1(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<CurrencyModel>?>?>?
//
//    @GET("back-end/admin/api/v1/getleavestatusdd")
//    fun getRequestStatus(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<RequestStatusModel>?>?>?
//
//
//    @GET("back-end/common/api/v1/getcountrydd")
//    fun getCountries(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<CountryModel>?>?>?
//
//// rporequest
//    @GET("back-end/admin/api/v1/getcountrydd")
//    fun getPoCountries(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<CountryModel>?>?>?
//
//    @GET("back-end/admin/api/v1/get-inandout-statuses")
//    fun getHrmRequestStatus(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("inAndOutId") id: String?
//    ): Call<ResultAPIModel<MutableList<HrmRequestStatus>?>?>?
//
//    @GET("back-end/admin/api/v1/getsupplierlanguage")
//    fun getSupplierLanguage(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("supplierId") id: String?
//    ): Call<ResultAPIModel<MutableList<TblSupplierLang>?>?>?
//
//    @GET("back-end/admin/api/v1/get-porequest-location")
//    fun getLocationList(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryParams: MutableMap<String, Any?>
//    ): Call<List<TblPurchaseRequestLocation?>?>?
//
//
//    @GET("back-end/admin/api/v1/get-porequest-location-facility")
//    fun getPoRequestLocationFacility(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?
//    ): Call<List<RequestLocationFacility?>?>?
//
//
//    @GET("back-end/admin/api/v1/getrequestapprovalheirarchy")
//    fun getRequestApproveHierarchy(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?
//    ): Call<ResultAPIModel<RequestApprovalHeirarchyModel?>?>?
//
//    @GET("back-end/admin/api/v1/getapprovedapprover")
//    fun getApproverDetails(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryParams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<RistRequestWorkflowApprovalHeirarchy?>?>?
//
//
//    @GET("back-end/admin/api/v1/getrequestedfile")
//    fun getrequestedfile(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?
//    ): Call<ResultAPIModel<String?>?>?
//
//
//    @GET("back-end/admin/api/v1/getapprovedfile")
//    fun getapprovedfile(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?
//    ): Call<ResultAPIModel<String>?>?
//
//
//    @GET("back-end/admin/api/v1/getapprovedleveldetails")
//    fun getApprovedLevelDetails(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryParams: MutableMap<String, Any?>
//    ): Call<ResultAPIModel<MutableList<RistRequestWorkflowApprovalHeirarchy>?>?>?
//
//    @GET("back-end/admin/api/v1/user/loggeduserdata")
//    fun getUserData(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//    ): Call<ResultAPIModel<ProfileModel?>?>?
//
//    @GET("back-end/admin/api/v1/user/loggeduserdata")
//    fun getPoUserData(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//    ): Call<ResultAPIModel<ProfilePoModel?>?>?
//
//
//    @GET("back-end/common/api/v1/user/loggeduserdata")
//    fun getHrmData(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//    ): Call<ResultAPIModel<ProfileModel?>?>?
//
//
//    @GET("back-end/admin/api/v1/get-poitem-images-with-url")
//    fun getPoItemImage(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("itemId") PoItemId: String?,
//    ): Call<ResultAPIModel<MutableList<PoItemImage>?>?>?
//
//    @GET("back-end/admin/api/v1/get-poitem-images")
//    fun getPoItemImages(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("itemId") PoItemId: String?,
//    ): Call<ResultAPIModel<MutableList<PoItemImage>?>?>?
//
//
//    @GET("back-end/admin/api/v1/get-poitem-defaultimage")
//    fun getDefaultPoItemImages(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("itemId") PoItemId: String?,
//    ): Call<ResultAPIModel<String?>?>?
//
//
//    @GET("back-end/admin/api/v1/getsuppliercurrency")
//    fun getSupplierCurrency(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("supplierId") PoItemId: String?,
//    ): Call<ResultAPIModel<CurrencySupplier>?>?
//
//
//    @GET("back-end/admin/api/v1/get-po-report")
//    @Streaming
//    fun getPoReport(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?,
//    ): Call<ResponseBody?>?
//
//
//    //...............................DELETE..................................
//
//    @DELETE("back-end/admin/api/v1/deletesupplier")
//    fun deleteSupplier(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?
//    ): Call<ResultAPIModel<String?>?>?
//
//
//    @DELETE("back-end/admin/api/v1/delete-porequest-item")
//    fun deletePoPoItemRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("ItemId") PoItemId: String?,
//    ): Call<ResultAPIModel<Boolean?>?>?
//
//    @DELETE("back-end/admin/api/v1/delete-poitem-image")
//    fun deletePoPoItemImage(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("imageId") imageId: String?,
//    ): Call<ResultAPIModel<Boolean?>?>?
//
//    //...............................PUT..................................
//
//    @POST("back-end/admin/api/v1/upload-poitem-image-new")
//    fun uploadItemImage(
//        @HeaderMap headerParam: MutableMap<String, Any>,
//        @Query("itemId") itemId: String?,
//        @Body requestBody: RequestBody?
//    ): Call<ResultAPIModel<PoItemImage?>?>?
//
//
////    @Headers("User-Agent: Mozilla/5.0 (X11; CrOS x86_64 8172.45.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.64 Safari/537.36" )
//    @PUT("back-end/admin/api/v1/upload-poitem-image")
//    fun uploadItemImage3(
//        @HeaderMap headerParam: MutableMap<String, Any>,
//        @Query("itemId") itemId: String?,
//        @Body file: RequestBody
//    ): Call<ResultAPIModel<PoItemImage?>?>?
//
//
//    @Multipart
//    @POST("back-end/admin/api/v1/upload-poitem-image")
//    fun uploadItemImage4(
//        @HeaderMap headerParam: MutableMap<String, Any>,
//        @Query("itemId") itemId: String?,
//        @Part image: MultipartBody.Part
//    ): Call<ResponseBody?>?
//
//    @PUT("back-end/admin/api/v1/update-porequest-notes")
//    fun updateNotes(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?,
//        @Body param: RequestPoModel?
//    ): Call<ResultAPIModel<RequestPoModel?>?>?
//
//
//    @PUT("back-end/admin/api/v1/update-poitem-defaultimage")
//    fun updateDefaultPoItemImage(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("imageId") imageId: String?,
//    ): Call<ResultAPIModel<String?>?>?
//
//
//    @PUT("back-end/admin/api/v1/update-porequest-estdate")
//    fun updateDate(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?,
//        @Body param: RequestPoModel?
//    ): Call<ResultAPIModel<RequestPoModel?>?>?
//
//
//    @PUT("back-end/admin/api/v1/cancel-porequest")
//    fun cancelPoRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?,
//    ): Call<ResultAPIModel<RequestPoModel?>?>?
//
//    @PUT("back-end/admin/api/v1/update-and-send-porequest")
//    fun sendPoRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?,
//    ): Call<ResultAPIModel<RequestPoModel?>?>?
//
//    @PUT("back-end/admin/api/v1/clone-porequest")
//    fun clonePoRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?,
//    ): Call<ResultAPIModel<RequestPoModel?>?>?
//
//    @PUT("back-end/admin/api/v1/update-inandout-request")
//    fun updateRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?,
//        @Body param: CreateRequestCall?
//    ): Call<ResultAPIModel<RequestHrmModel?>?>?
//
////    @PUT("back-end/admin/api/v1/update-porequest-item-qty")
////    fun updateItemQuan(
////        @HeaderMap headerParams: MutableMap<String, Any>,
////        @Query("PoItemId") PoItemId: String?,
////        @Body param: TblPurchaseRequestItem?
////    ): Call<ResultAPIModel<TblPurchaseRequestItem?>?>?
//
////    @PUT("back-end/admin/api/v1/update-porequest-location-new")
////    fun updateItemQuanNew(
////        @HeaderMap headerParams: MutableMap<String, Any>,
////        @Query("PoItemId") PoItemId: String?,
////        @Body param: TblPurchaseRequestLocation?
////    ): Call<ResultAPIModel<TblPurchaseRequestItem?>?>?
////
//
//
//    @PUT("back-end/admin/api/v1/update-porequest-location")
//    fun updatePoRequestLocation(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @QueryMap queryparams: MutableMap<String, Any?>,
//        @Body param: TblPurchaseRequestLocation?
//    ): Call<ResultAPIModel<TblPurchaseRequestItem?>?>?
//
//
//    @PUT("back-end/admin/api/v1/update-inandout-status")
//    fun updateRequestStatus(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("inAndOutId") id: String?,
//        @Body param: CreateRequestCall?
//    ): Call<ResultAPIModel<Any?>?>?
//
//
//    @PUT("back-end/admin/api/v1/updatesupplier")
//    fun updateSupplier(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?,
//        @Body param: AddSupplierCall?
//    ): Call<ResultAPIModel<SupplierModel?>?>?
//
//    @PUT("back-end/admin/api/v1/create-porequest-item")
//    fun createPoRequestItem(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("PoId") id: String?,
//        @Body param: TblPurchaseRequestItem?
//    ): Call<ResultAPIModel<TblPurchaseRequestItem?>?>?
//
//
//    @PUT("back-end/admin/api/v1/update-porequest-item")
//    fun updatePoPoItemRequest(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("PoItemId") PoItemId: String?,
//        @Body param: TblPurchaseRequestItem?
//    ): Call<ResultAPIModel<TblPurchaseRequestItem?>?>?
//
//
//
//
//    @PUT("back-end/admin/api/v1/update-porequest-route")
//    fun updateRoute(
//        @HeaderMap headerParams: MutableMap<String, Any>,
//        @Query("id") id: String?,
//        @Body param: RequestPoModel?
//    ): Call<ResultAPIModel<RequestPoModel?>?>?


}



