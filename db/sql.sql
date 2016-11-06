Запрос на поиск пересекающихся деталей и дат:
SELECT ro.room_id, ro.booked_start_day, ro.booked_end_day FROM room_order ro JOIN room r ON (ro.room_id=r.id) WHERE (r.room_details_id=1) AND (ro.booked_start_day = "2015-12-30" OR ro.booked_start_day < "2015-12-30") AND (ro.booked_end_day="2015-12-25" OR ro.booked_end_day > "2015-12-25");



