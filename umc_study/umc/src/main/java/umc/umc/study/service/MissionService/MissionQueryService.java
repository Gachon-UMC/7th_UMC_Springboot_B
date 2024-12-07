package umc.umc.study.service.MissionService;

import org.springframework.data.domain.Page;
import umc.umc.study.domain.Mission;
import umc.umc.study.domain.Review;

public interface MissionQueryService {
    Page<Mission> getStoreMissionList(Integer store_id, Integer page);
    Page<Mission> getUserMissionList(Integer user_id, Integer page);
    Mission patchUserMission(Integer user_id, Long mission_id);

}
