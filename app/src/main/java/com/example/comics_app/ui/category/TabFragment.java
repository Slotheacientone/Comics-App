package com.example.comics_app.ui.category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comics_app.R;
import com.example.comics_app.model.Comic;
import com.example.comics_app.ui.category.adapter.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabFragment extends Fragment {

    private String title;
    private RecyclerView recyclerView;
    private List<Comic> comicList = new ArrayList<Comic>();

    public TabFragment(String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        initializeComicList();
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this.getContext(), comicList);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    public void initializeComicList() {
        Comic comic1 = new Comic("Con Gái Bảo Bối Của Ma Vương",
                "Từ khi ở nhà cô, tôi bị bắt nạt rất nhiều. Muốn kết bạn nhưng vì béo mập nên bị bạn bè cô lập… sao đời người lại khó khăn như thế? Tôi chỉ muốn sống thật tốt! Sau một vụ tai nạn xe, lần nữa mở mắt ra, gì cơ? Đây là ma giới? Cha tôi là vua ma giới?! Người cha ma vương này quả thực cuồng cưng chiều con gái, ngay cả những tiểu ca ca cũng yêu chiều bảo bảo tôi đây tận trời, hạnh phúc quá!!",
                "Action - Comedy - Manhua - Mystery - Truyện Màu - Xuyên Không",
                "https://st.truyenchon.com/data/comics/69/con-gai-bao-boi-cua-ma-vuong.jpg",
                15);
        comicList.add(comic1);
        Comic comic2 = new Comic(
                "Ngôn Linh Vương",
                "Một bộ manga chuyển thể từ light novel hot nhất Nhật Bản. Đã có rất nhiều cuộc xung đột giữa các chủng tộc của các Humas, các Gabranth, và Evila. Để chống lại Demon King Evila cuộc đua, các vương quốc triệu tập năm học sinh trung học từ thế kỷ 21 Nhật Bản những người có sức mạnh của Heroes. Tuy nhiên, chỉ có bốn trong số năm của những sinh viên đã có danh hiệu Hero. Okamura Hiiro đã được triệu hồi do tai nạn khi cậu ngồi gần bốn học sinh khác trong lớp. Không giống như họ, cậu không có danh hiệu Hero, nhưng thay vào đó cậu đã có được danh hiệu Word Master và người ngoài cuộc vô tội. Thấy được sự dối trá của Quốc Vương Humas, Hiiro quyết định rằng cậu không có ý muốn tham gia vào cuộc chiến một cách ích kỷ. Rời khỏi lâu đài, Hiiro quyết định gia nhập Guild Adventurer và làm bất cứ điều gì cậu muốn",
                "Adventure - Chuyển Sinh - Comedy - Fantasy - Shounen",
                "https://st.truyenchon.com/data/comics/230/ngon-linh-vuong.jpg",
                15);
        comicList.add(comic2);
        Comic comic3 = new Comic(
                "Xông Vào Tim Anh",
                "Để thực hiện ước mơ đi nước ngoài du học, học bá Ninh Tiểu Cận ban ngày chăm chỉ học hành, ban đêm hát thuê ở quán bar. Những ngày bình thường bị một tên trộm xuất hiện phá vỡ - một tên trộm không trộm gì cả, lại nhiều lần dọn dẹp nhà cho cô? Sự nghi hoặc lạ lùng khiến Ninh Tiểu Cận phải bắt đầu tìm hiểu, càng tìm hiểu sâu, Ninh Tiểu Cận phát hiện tên trộm vậy mà lại có liên quan đến kẻ thù không đội trời chung ở trường - đệ nhất học thần Châu Ức…",
                "Manhua - Ngôn Tình - Romance - School Life - Shoujo - Truyện Màu",
                "https://st.truyenchon.com/data/comics/221/xong-vao-tim-anh.jpg",
                15
        );
        comicList.add(comic3);
        Comic comic4 = new Comic(
                "Thần Cấp Thấu Thị",
                "Một lần ngoài ý muốn để Diệp Hàn có được thần kỳ năng lực nhìn xuyên tường, từ đây nhân sinh của hắn trở nên muôn màu muôn vẻ, khai thác mạnh nhất thương nghiệp đế quốc, xưng bá thế giới cược đàn, một tay y thuật diệu thủ hồi xuân, trở thành y đạo thánh thủ, có được ức vạn tài phú, la lỵ, ngự tỷ, hoa khôi cảnh sát, nữ thần nhao nhao hướng hắn đánh tới, làm một bản số lượng có hạn nam nhân, Diệp Hàn áp lực rất lớn, bất đắc dĩ cùng mấy cái kẻ trộm mộ đi dò thám hiểm, nhưng mà, một cái từ viễn cổ truy tìm đến nay bí mật kinh thiên dần dần hiện lên ở hắn trước mắt!...",
                "Action - Manhua - Mystery - Truyện Màu",
                "https://st.truyenchon.com/data/comics/193/than-cap-thau-thi.jpg",
                15
        );
        comicList.add(comic4);
        Comic comic5 = new Comic(
                "Ma Vương Đại Nhân, Phu Nhân Lại Bỏ Đi Rồi!",
                "Xuyên qua thế giới khác, lại nhập vào thân xác của 1 phế vật. Hừ, những kẻ đang ức hiếp ta, các ngươi phải trả giá...",
                "Comedy - Manhua - Ngôn Tình - Romance - Shounen - Truyện Màu",
                "https://st.truyenchon.com/data/comics/107/ma-vuong-dai-nhan-phu-nhan-lai-bo-di-roi-7121.jpg",
                15
        );
        comicList.add(comic5);
        Comic comic6 = new Comic(
                "Cô bạn gái mà mình thích lại quên mang kính mất rồi",
                "Komura là một cậu học sinh đang thích thầm cô bạn gái ngồi kế bên mình tên là Mie-Một cô bé thường hay để quên kính của mình. Và với cục thính cực mạnh và cực kì ngọt từ cô bạn này, thì liệu cậu Komura nhà ta có thể đỡ được không",
                "Comedy - Romance - School Life - Slice of Life",
                "https://st.truyenchon.com/data/comics/212/co-ban-gai-ma-minh-thich-lai-quen-mang-k-2766.jpg",
                15
        );
        comicList.add(comic6);
    }

}