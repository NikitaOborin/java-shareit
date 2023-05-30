package ru.practicum.shareit.item.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.mapper.ItemMapper;
import ru.practicum.shareit.item.repository.ItemRepository;
import ru.practicum.shareit.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final ItemMapper mapper;

    @Override
    public ItemDto createItem(Long userId, ItemDto itemDto) {
        return mapper.toItemDto(itemRepository.createItem(userRepository.getUser(userId), mapper.toItem(itemDto)));
    }

    @Override
    public ItemDto updateItem(Long itemId, ItemDto itemDto, Long userId) {
        return mapper.toItemDto(itemRepository.updateItem(itemId, mapper.toItem(itemDto), userId));
    }

    @Override
    public ItemDto getItem(Long itemId, Long userId) {
        return mapper.toItemDto(itemRepository.getItem(itemId));
    }

    @Override
    public List<ItemDto> getItemsByUser(Long userId) {
        return itemRepository.getItemsByUser(userId).stream()
                .map(mapper::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> getAvailableItems(Long userId, String text) {
        return itemRepository.getAvailableItems(userId, text).stream()
                .map(mapper::toItemDto)
                .collect(Collectors.toList());
    }
}