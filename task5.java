private static final Logger logger = LoggerFactory.getLogger(DocumentValidator.class);

public ValidationResult validate(Document doc) {
 
    try {
        if (doc == null) {
            //FIX : using logs for validation failure
              logger.warn("Document is null");              
             return new ValidationResult(false);
        }
        String content = doc.extractContent();
        if (content.isEmpty()) {
            //FIX : using logs for validation failure    
logger.warn(“content null”);
return new ValidationResult(false);

    }
        return runValidationRules(content);

    } catch (Exception e) {
//Fix : USING LOGGER instead of printstacktrace
logger.error(“Unexpected validation error”,e);

//	FIX : NO RETURNING NULL

        return new ValidationResult(false);
    }
}

public void validateBatch(List<Document> docs) {
    for (Document doc : docs) {
        try {
            ValidationResult r = validate(doc);

//FIX : adding condition to ensure no null pointer excpetion occurs
if (r != null && r.isValid()) {
saveResult(r);
}
            
        } catch (Exception e) {
           //Fix: using logger here
logger.error("Batch validation failure", e);
        }
    }
}
