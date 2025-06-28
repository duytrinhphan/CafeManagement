package com.viettridao.cafe.service.account;

import java.util.List;
import java.util.Optional;

import com.viettridao.cafe.dto.request.account.AccountCreateRequest;
import com.viettridao.cafe.dto.request.account.AccountUpdateRequest;
import com.viettridao.cafe.dto.response.account.AccountResponse;
import com.viettridao.cafe.dto.response.profile.ProfileResponse;
import com.viettridao.cafe.model.AccountEntity;

public interface IAccountService {

    List<AccountResponse> getAllAccount();

    void createAccount(AccountCreateRequest request);

    AccountUpdateRequest getUpdateForm(Integer id);

    void updateAccount(Integer id, AccountUpdateRequest request);

    void deleteAccount(Integer id);

    ProfileResponse getProfileByAccountId(Integer accountId);
}
