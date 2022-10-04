package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.AddStoreProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.AddStoreRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.GetAllItemsRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.AddStoreProductResponse;
import com.hotsystemsng.lumexpress.data.dtos.responses.AddStoreResponse;
import com.hotsystemsng.lumexpress.data.dtos.responses.DeleteStoreResponse;
import com.hotsystemsng.lumexpress.data.models.Store;

import java.util.List;

public interface StoreService {
    AddStoreResponse addStore(AddStoreRequest request);

    GetStoreResponse getStore(Long id);

    List<Store> getAllStores(GetAllItemsRequest request);

    AddStoreProductResponse addStoreProduct(AddStoreProductRequest request);

    DeleteStoreResponse deleteStore(Long id);

}
