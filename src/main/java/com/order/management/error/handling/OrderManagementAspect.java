package com.order.management.error.handling;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.order.management.model.ErrorModel;

@Aspect
//@Component
public class OrderManagementAspect {
	@AfterThrowing(value = "execution(* com.order.management.controller.*(..))", throwing = "ex")
	public ResponseEntity<ErrorModel> afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
		System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
		System.out.println("Exception is:" + ex.getMessage());
		ErrorModel errorModel = new ErrorModel();
		errorModel.setErrorCode("400");
		errorModel.setMsg(ex.getMessage());
		return new ResponseEntity<ErrorModel>(errorModel, HttpStatus.BAD_REQUEST);
	}
}
