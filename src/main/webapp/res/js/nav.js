document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav.main");

  const navClickHandler = (e) => {
    const current = e.currentTarget;
    const target = e.target;

    if (target.tagName === "LI") {
      const targetClassName = target.className;
      console.log(targetClassName);
      let URL = `${rootPath}/` + targetClassName;
      const USER_URL = "login join mypage logout";
      if (targetClassName === "book") {
        URL = `${rootPath}`;
      } else if (USER_URL.indexOf(targetClassName) > -1) {
        URL = `${rootPath}/` + targetClassName;
      }

      document.location.href = URL;
    }
  };
  nav?.addEventListener("click", navClickHandler);
});
