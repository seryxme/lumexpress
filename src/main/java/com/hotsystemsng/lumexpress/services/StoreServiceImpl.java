package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.AddStoreProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.AddStoreRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.GetAllItemsRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.AddStoreProductResponse;
import com.hotsystemsng.lumexpress.data.dtos.responses.AddStoreResponse;
import com.hotsystemsng.lumexpress.data.dtos.responses.DeleteStoreResponse;
import com.hotsystemsng.lumexpress.data.models.Store;
import com.hotsystemsng.lumexpress.data.repositories.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public AddStoreResponse addStore(AddStoreRequest request) {
        return null;
    }

    @Override
    public GetStoreResponse getStore(Long id) {
        return null;
    }

    @Override
    public List<Store> getAllStores(GetAllItemsRequest request) {
        return null;
    }

    @Override
    public AddStoreProductResponse addStoreProduct(AddStoreProductRequest request) {
        return null;
    }

    @Override
    public DeleteStoreResponse deleteStore(Long id) {
        return null;
    }
}
