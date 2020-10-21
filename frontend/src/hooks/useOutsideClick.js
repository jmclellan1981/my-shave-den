import { useEffect } from "react";

const useOutsideClick = (ref, action) => {
  useEffect(() => {
    const detectOutsideClick = event => {
      if (!ref.current.contains(event.target)) {
        action();
      }
    };

    window.addEventListener("click", detectOutsideClick);

    return () => {
      window.removeEventListener("click", detectOutsideClick);
    };
  }, [ref, action]);
};

export { useOutsideClick };
