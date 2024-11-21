import classes from "./Post.module.css"

const array = ["Neeraj","Lallu"]

function Post(props){

  const choseName  =  Math.random() > 0.5? array[0]:array[1];
  return (
  <div className={classes.post}>
    <h1>
      {props.author}
    </h1>

    <h1>
      {props.post}
    </h1>
    </div>
  );


}

export default Post;
