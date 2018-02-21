package com.locate.entity.finder;

public interface EntityFinder<T, R> {
	
	R findEntity(T t);

}
