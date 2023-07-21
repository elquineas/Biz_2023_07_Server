const ERROR_MESSAGE_USER = {
  CODE: "* 유저코드를 입력하세요",
  NAME: "* 유저명을 입력하세요",
};
document.addEventListener("DOMContentLoaded", () => {
  const user_save = document.querySelector("#user_save");
  const btn_search = document.querySelector("#user_btn");

  const input_sort = document.querySelector("#user_sort");
  const input_u_code = document.querySelector("#u_code");
  const input_u_name = document.querySelector("#u_name");
  const input_u_tel = document.querySelector("#u_tel");
  const input_u_addr = document.querySelector("#u_addr");

  const error_err_box = document.querySelector("div.msg");

  btn_search?.addEventListener("click", () => {
    document.querySelector("form.user_search").submit();
  });

  user_save?.addEventListener("click", async () => {
    const sort_check = input_sort.value;
    if (sort_check === "I") {
      if (!err_massage(input_u_code, error_err_box, ERROR_MESSAGE_USER.CODE)) {
        return false;
      }
      if (!err_massage(input_u_name, error_err_box, ERROR_MESSAGE_USER.NAME)) {
        return false;
      }

      const code = input_u_code.value;
      const tel = input_u_tel.value;
      const res = await fetch(
        `${rootPath}/user/check?u_code=${code}&u_tel=${tel}`
      );
      const json = await res.json();
      console.log(json);
      if (json.u_code === "NOT") {
        error_err_box.innerHTML = "* 등록된 회원 입니다.";
        input_u_code?.select();
        return false;
      }
      error_err_box.innerHTML = "";
      document.querySelector("form.main").submit();
      return false;
    } else if (sort_check === "U") {
      document.querySelector("form.main").submit();
    }
  });
});
