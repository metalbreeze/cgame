package com.cgame.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cgame.entity.Platform;
import com.cgame.exception.GeneralException;
import com.cgame.repository.PlatformRepository;

@Service
public class PlatformService {
	@Autowired
	private PlatformRepository platformRepository;
	@Cacheable(value = "platforms")
	public Platform findOne(Long id) {
		Optional<Platform> platforms = platformRepository.findById(id);
		Platform platform = platforms.isPresent()?platforms.get():null;
		if (platform == null)
			throw new GeneralException("can not find it");
		return platform;
	}
}
