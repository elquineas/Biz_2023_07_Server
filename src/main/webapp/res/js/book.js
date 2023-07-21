const ERROR_MESSAGE = {
  CODE: "* 도서코드를 입력하세요",
  NAME: "* 도서명을 입력하세요",
  AUTHER: "* 저자를 입력하세요",
  YEAR: "* 구입연도를 입력하세요",
  RPRICE: "* 대여가격을 입력하세요",
};

document.addEventListener("DOMContentLoaded", () => {
  const input_sort = document.querySelector("#sort");
  const input_comp = document.querySelector("#b_comp");
  const input_code = document.querySelector("#b_code");
  const input_name = document.querySelector("#b_name");
  const input_auth = document.querySelector("#b_auther");
  const input_year = document.querySelector("#b_year");
  const input_iprice = document.querySelector("#b_iprice");
  const input_rprice = document.querySelector("#b_rprice");

  const btn_save = document.querySelector("#btn_save");
  const btn_search = document.querySelector("#book_btn");

  const error_err_box = document.querySelector("div.msg");

  input_code?.select();
  //   input_code?.addEventListener("blur", async () => {
  //     if (!err_massage(input_code, error_err_box, ERROR_MESSAGE.CODE)) {
  //       return false;
  //     }
  //     const code = input_code.value;
  //     const res = await fetch(`${rootPath}/check?b_code=${code}`);
  //     const json = await res.json();
  //     // console.log(json);
  //     if (json.b_code === "NOT") {
  //       error_err_box.innerHTML = "* 등록된 도서번호 입니다.";
  //       input_code?.select();
  //       return false;
  //     }
  //     error_err_box.innerHTML = "";
  //   });
  //   input_name?.addEventListener("blur", () => {
  //     if (!err_massage(input_name, error_err_box, ERROR_MESSAGE.NAME)) {
  //       return false;
  //     }
  //   });
  //   input_auth?.addEventListener("blur", () => {
  //     if (!err_massage(input_auth, error_err_box, ERROR_MESSAGE.AUTHER)) {
  //       return false;
  //     }
  //   });
  //   input_year?.addEventListener("blur", () => {
  //     if (!err_massage(input_year, error_err_box, ERROR_MESSAGE.YEAR)) {
  //       return false;
  //     }
  //   });
  //   input_rprice?.addEventListener("blur", () => {
  //     if (!err_massage(input_rprice, error_err_box, ERROR_MESSAGE.RPRICE)) {
  //       return false;
  //     }
  //   });

  btn_save?.addEventListener("click", async () => {
    const sort_check = input_sort.value;
    if (sort_check === "I") {
      if (!err_massage(input_code, error_err_box, ERROR_MESSAGE.CODE)) {
        return false;
      }

      if (!err_massage(input_name, error_err_box, ERROR_MESSAGE.NAME)) {
        return false;
      }
      const code = input_code.value;
      const name = input_name.value;
      const res = await fetch(
        `${rootPath}/check?b_code=${code}&b_name=${name}`
      );
      const json = await res.json();
      // console.log(json);
      if (json.b_code === "NOT_CODE") {
        error_err_box.innerHTML = "* 등록된 도서번호 입니다.";
        input_code?.select();
        return false;
      } else if (json.b_code === "NOT_NAME") {
        error_err_box.innerHTML = "* 등록된 도서명 입니다.";
        input_code?.select();
        return false;
      }

      if (!err_massage(input_auth, error_err_box, ERROR_MESSAGE.AUTHER)) {
        return false;
      }
      if (!err_massage(input_year, error_err_box, ERROR_MESSAGE.YEAR)) {
        return false;
      }
      if (!err_massage(input_rprice, error_err_box, ERROR_MESSAGE.RPRICE)) {
        return false;
      }

      error_err_box.innerHTML = "";
      document.querySelector("form.main").submit();

      // if (
      //   err_massage(input_code, error_err_box, ERROR_MESSAGE.CODE) &&
      //   err_massage(input_name, error_err_box, ERROR_MESSAGE.NAME) &&
      //   err_massage(input_auth, error_err_box, ERROR_MESSAGE.AUTHER) &&
      //   err_massage(input_year, error_err_box, ERROR_MESSAGE.YEAR) &&
      //   err_massage(input_rprice, error_err_box, ERROR_MESSAGE.RPRICE)
      // ) {
      //   document.querySelector("form.main").submit();
      // }
      return false;
    } else if (sort_check === "U") {
      document.querySelector("form.main").submit();
    }
  });

  const list_table = document.querySelector("table.main.list");
  const trClickHander = async (e) => {
    const temp = e.target;
    const target_tagName = e.target.tagName;
    const click_target = temp.closest("TR");
    const id = click_target.dataset.id;
    // console.log(id);

    if (id !== null && target_tagName === "A") {
      const res = await fetch(`${rootPath}/update_check?b_code=${id}`);
      const json = await res.json();
      //   console.log(json);
      input_sort.value = "U";
      input_code.value = json.b_code;
      input_name.value = json.b_name;
      input_auth.value = json.b_auther;
      input_year.value = json.b_year;
      input_rprice.value = json.b_rprice;
      input_comp.value = json.b_comp;
      input_iprice.value = json.b_iprice;
    }
  };
  list_table?.addEventListener("click", trClickHander);
  btn_search?.addEventListener("click", () => {
    document.querySelector("form.book_search").submit();
  });
});
