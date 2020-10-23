import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { UPDATE_WISHLIST_FILTER } from "../../reducers";

const FilterOption = ({ data, filters }) => {
  const dispatch = useDispatch();
  const [isSelected, setIsSelected] = useState(
    filters.sites.includes(data.name) || filters.categories.includes(data.name)
  );

  return (
    <div>
      <input
        type="checkbox"
        checked={isSelected}
        onChange={() => {
          const payload = { option: data.name, type: data.type };
          payload.isSelected = !isSelected;
          dispatch({ type: UPDATE_WISHLIST_FILTER, payload });
          setIsSelected(isSelected => !isSelected);
        }}
      />
      {data.description}
    </div>
  );
};

export { FilterOption };
