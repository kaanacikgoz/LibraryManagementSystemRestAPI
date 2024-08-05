package com.acikgozKaan.LibraryAPI.api;

import com.acikgozKaan.LibraryAPI.business.abstracts.IPublisherService;
import com.acikgozKaan.LibraryAPI.core.result.ResultData;
import com.acikgozKaan.LibraryAPI.core.utilies.ResultHelper;
import com.acikgozKaan.LibraryAPI.dto.request.publisher.PublisherSaveRequest;
import com.acikgozKaan.LibraryAPI.dto.response.AuthorResponse;
import com.acikgozKaan.LibraryAPI.dto.response.PublisherResponse;
import com.acikgozKaan.LibraryAPI.entity.Author;
import com.acikgozKaan.LibraryAPI.entity.Publisher;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {

    private final IPublisherService publisherService;

    public PublisherController(IPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest) {

        Publisher publisher = new Publisher(
                publisherSaveRequest.getName(),
                publisherSaveRequest.getEstablishmentYear(),
                publisherSaveRequest.getAddress(),
                publisherSaveRequest.getBookList()
        );

        this.publisherService.save(publisher);

        PublisherResponse publisherResponse = new PublisherResponse(
                publisher.getId(),
                publisher.getName(),
                publisher.getEstablishmentYear(),
                publisher.getAddress(),
                publisher.getBookList()
        );

        return ResultHelper.created(publisherResponse);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private ResultData<List<PublisherResponse>> getAll() {
        List<Publisher> publishers = publisherService.getAll();

        List<PublisherResponse> publisherResponses = publishers.stream().map(publisher -> new PublisherResponse(
                publisher.getId(),
                publisher.getName(),
                publisher.getEstablishmentYear(),
                publisher.getAddress(),
                publisher.getBookList()
        )).collect(Collectors.toList());

        return ResultHelper.ok(publisherResponses);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResultData<Publisher> delete(@PathVariable("id")Long id) {
        Publisher deletedPublisher = this.publisherService.getById(id);
        this.publisherService.delete(id);
        return ResultHelper.deleted(deletedPublisher);
    }

}
