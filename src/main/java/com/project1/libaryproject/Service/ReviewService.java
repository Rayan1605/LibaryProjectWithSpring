package com.project1.libaryproject.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional //  commits the transaction after the method completes successfully.
// If an exception is thrown, the transaction will be rolled back.
public class ReviewService {
}
