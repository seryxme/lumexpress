package com.hotsystemsng.lumexpress.data.dtos.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllItemsRequest {
    private int numberOfItemsPerPage;
    private int pageNumber;
}
