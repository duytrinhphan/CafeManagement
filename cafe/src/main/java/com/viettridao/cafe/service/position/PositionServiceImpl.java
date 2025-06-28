package com.viettridao.cafe.service.position;

import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.viettridao.cafe.dto.request.position.PositionCreateRequest;
import com.viettridao.cafe.dto.request.position.PositionUpdateRequest;
import com.viettridao.cafe.dto.response.position.PositionResponse;
import com.viettridao.cafe.mapper.PositionMapper;
import com.viettridao.cafe.model.PositionEntity;
import com.viettridao.cafe.repository.PositionRepository;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements IPositionService{

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    @Override
    public List<PositionResponse> getPositionAll() {
        return positionRepository.findPositionByDeletedFalse()
                .stream()
                .map(positionMapper::toResponse)
                .toList();
    }

    @Override
    public PositionEntity getPositionById(Integer id) {

        PositionEntity entity = findPositionOrThrow(id);

        return entity;
    }

    @Override
    @Transactional
    public void createPosition(PositionCreateRequest request) {

        PositionEntity entity = positionMapper.toEntity(request);

        positionRepository.save(entity);

    }

    @Override
    public PositionUpdateRequest getUpdateForm(Integer id) {

        return positionMapper.toUpdateRequest(findPositionOrThrow(id));
    }

    @Override
    @Transactional
    public void updatePosition(Integer id, PositionUpdateRequest request) {

        PositionEntity existing = findPositionOrThrow(id);

        positionMapper.updateFromRequest(request, existing);

        positionRepository.save(existing);
    }

    @Override
    public void deletePosition(Integer id) {

        PositionEntity entity = findPositionOrThrow(id);

        entity.setDeleted(true);

        positionRepository.save(entity);
    }

    private PositionEntity findPositionOrThrow(Integer id) {
        return positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chức vụ với id =" + id));
    }
}
