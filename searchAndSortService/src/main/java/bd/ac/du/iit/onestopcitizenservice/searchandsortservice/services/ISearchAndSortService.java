package bd.ac.du.iit.onestopcitizenservice.searchandsortservice.services;

import bd.ac.du.iit.onestopcitizenservice.searchandsortservice.interfaces.*;

public interface ISearchAndSortService {
    public ValidationWithSearchByNameResponse searchByNameWithValidation(ValidationWithSearchByNameRequest request);
    public ValidationWithSearchByCategoryResponse searchByCategoryWithValidation(ValidationWithSearchByCategoryRequest request);
    public ValidationWithSearchByContactResponse searchByContactWithValidation(ValidationWithSearchByContactRequest request);
}
