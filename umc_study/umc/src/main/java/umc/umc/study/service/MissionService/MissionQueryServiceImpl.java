package umc.umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.umc.study.domain.Mission;
import umc.umc.study.domain.Review;
import umc.umc.study.domain.Store;
import umc.umc.study.domain.Users;
import umc.umc.study.repository.MissionRepository;
import umc.umc.study.repository.ReviewRepository;
import umc.umc.study.repository.StoreRepository;
import umc.umc.study.repository.UsersRepository;
import umc.umc.study.service.MissionService.MissionQueryService;
import umc.umc.study.web.dto.ReviewDTO.ReviewResponseDto;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;

    private final UsersRepository usersRepository;


    @Override
    public Page<Mission> getStoreMissionList(Integer store_id, Integer page) {

        Store store = storeRepository.findById(store_id).get();

        Page<Mission> StorePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Mission> getUserMissionList(Integer user_id, Integer page) {

        Users users = usersRepository.findById(user_id).get();

        Page<Mission> UserPage = missionRepository.findAllByUsers(users, PageRequest.of(page, 10));
        return UserPage;
    }

    @Override
    public Mission patchUserMission(Integer user_id, Long mission_id) {
        Users users = usersRepository.findById(user_id).get();

        Mission mission = users.getMission();

        if (mission.getId().equals(mission_id)){
            mission.setMissionStatus(1,mission.getTitle(),mission.getStore().getId());
            return mission.getUsers().getMission_status();
        } else{
            return null;
        }

    }


}
