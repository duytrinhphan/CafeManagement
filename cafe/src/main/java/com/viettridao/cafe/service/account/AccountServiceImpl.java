package com.viettridao.cafe.service.account;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.viettridao.cafe.dto.request.account.AccountCreateRequest;
import com.viettridao.cafe.dto.request.account.AccountUpdateRequest;
import com.viettridao.cafe.dto.response.account.AccountResponse;
import com.viettridao.cafe.dto.response.profile.ProfileResponse;
import com.viettridao.cafe.mapper.AccountMapper;
import com.viettridao.cafe.mapper.ProfileMapper;
import com.viettridao.cafe.model.AccountEntity;
import com.viettridao.cafe.repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService{

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final ProfileMapper profileMapper;

    @Override
    public List<AccountResponse> getAllAccount() {

        return accountRepository.findAllByDeletedFalse()
                .stream()
                .map(accountMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void createAccount(AccountCreateRequest request) {

        AccountEntity entity = accountMapper.toEntity(request);

        accountRepository.save(entity);
    }

    @Override
    public AccountUpdateRequest getUpdateForm(Integer id) {
        return accountMapper.toUpdateRequest(findAccountOrThrow(id));
    }


    @Override
    @Transactional
    public void updateAccount(Integer id, AccountUpdateRequest request) {

        AccountEntity existing = findAccountOrThrow(id);

        accountMapper.updateEntityFromRequest(request, existing);

        accountRepository.save(existing);
    }

    @Override
    @Transactional
    public void deleteAccount(Integer id) {

        AccountEntity entity = findAccountOrThrow(id);

        entity.setDeleted(true);

        accountRepository.save(entity);
    }

    @Override
    public ProfileResponse getProfileByAccountId(Integer accountId) {
        AccountEntity account = findAccountOrThrow(accountId);
        if (account.getEmployee() == null) {
            throw new RuntimeException("Không tìm thấy thông tin nhân viên cho tài khoản có ID = " + accountId);
        }
        return profileMapper.toProfile(account);
    }

    // Kiếm tài khoản theo id truyền vào
    private AccountEntity findAccountOrThrow(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản với id = " + id));
    }

}
